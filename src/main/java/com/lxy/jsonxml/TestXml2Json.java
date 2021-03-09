package com.lxy.jsonxml;

import cn.hutool.json.XML;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lxy
 */
public class TestXml2Json {
	public static void main(String[] args) throws Exception {
		String                    path   = GetResource.class.getClassLoader().getResource("P22K998002100000001.xml").getPath();
		String                    xmlStr = readFile(path);
		cn.hutool.json.JSONObject json1   = XML.toJSONObject(xmlStr);
		Document                  doc    = DocumentHelper.parseText(xmlStr);
		JSONObject                json   = new JSONObject();
		dom4j2Json(doc.getRootElement(), json);
		System.out.println("xml2Json:" + json.toJSONString());
		System.out.println("xml2Json:" + json1.toString());
		String                   password = JsonPath.parse(json).read("$.head.password");
		ArrayList<Map<String,Object>> list = JsonPath.parse(json).read("$.body.entity..insuredList.insured.*");
		for (Map<String,Object> map:list){
			System.out.println(map.get("customerName"));
			Map<String,Object> insurantAddType = (Map<String, Object>) map.get("insurantAddType");
			System.out.println(insurantAddType.get("insurantAttr"));
		}
//		System.out.println(len);
//		for (int i = 0; i < len; i++) {
////			System.out.println((char[]) JsonPath.parse(json).read("$.body.entity.insuredList["+i+"].insured.customerName"));
//		}
	}

	public static String readFile(String path) throws Exception {
		File            file = new File(path);
		FileInputStream fis  = new FileInputStream(file);
		FileChannel     fc   = fis.getChannel();
		ByteBuffer      bb   = ByteBuffer.allocate(new Long(file.length()).intValue());
		//fc向buffer中读入数据
		fc.read(bb);
		bb.flip();
		String str = new String(bb.array(), "UTF8");
		fc.close();
		fis.close();
		return str;

	}

	/**
	 * xml转json
	 *
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static JSONObject xml2Json(String xmlStr) throws DocumentException {
		Document   doc  = DocumentHelper.parseText(xmlStr);
		JSONObject json = new JSONObject();
		dom4j2Json(doc.getRootElement(), json);

		return json;
	}

	/**
	 * xml转json
	 *
	 * @param element
	 * @param json
	 */
	public static void dom4j2Json(Element element, JSONObject json) {
		//如果是属性
		for (Object o : element.attributes()) {
			Attribute attr = (Attribute) o;
			json.put("@" + attr.getName(), attr.getValue());
		}
		List<Element> chdEl = element.elements();
		//如果没有子元素,只有一个值
		if (chdEl.isEmpty()) {
			json.put(element.getName(), element.getText());
		}

		for (Element e : chdEl) {//有子元素
			if (!e.elements().isEmpty()) {//子元素也有子元素
				JSONObject chdjson = new JSONObject();
				dom4j2Json(e, chdjson);
				Object o = json.get(e.getName());
				if (o != null) {
					JSONArray jsona = null;
					if (o instanceof JSONObject) {//如果此元素已存在,则转为jsonArray
						JSONObject jsono = (JSONObject) o;
						json.remove(e.getName());
						jsona = new JSONArray();
						jsona.add(jsono);
						jsona.add(chdjson);
					}
					if (o instanceof JSONArray) {
						jsona = (JSONArray) o;
						jsona.add(chdjson);
					}
					json.put(e.getName(), jsona);
				} else {
					if (!chdjson.isEmpty()) {
						json.put(e.getName(), chdjson);
					}
				}
			} else {//子元素没有子元素
				for (Object o : element.attributes()) {
					Attribute attr = (Attribute) o;
					json.put("@" + attr.getName(), attr.getValue());
				}
				if (!e.getText().isEmpty()) {
					json.put(e.getName(), e.getText());
				}
			}
		}
	}
}
