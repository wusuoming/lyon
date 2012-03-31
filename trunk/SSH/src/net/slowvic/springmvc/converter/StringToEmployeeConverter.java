package net.slowvic.springmvc.converter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import net.slowvic.springmvc.model.Employee;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringToEmployeeConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String src) {
		if (src == null || !StringUtils.hasLength(src)) {
			return null;
		} else {
			String[] pairs = src.split(";");
			Map<String, String> fieldMap = new HashMap<String, String>();
			for (int i = 0; i < pairs.length; i++) {
				String[] fields = pairs[i].split(",");
				if (fields.length == 2) {
					fieldMap.put(fields[0], fields[1]);
				}
			}
			Employee employee = new Employee();
			try {
				BeanUtils.copyProperties(employee, fieldMap);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return employee;
		}
	}

	public static void main(String[] args) {
		String src = "sdfasd";
		StringToEmployeeConverter converter = new StringToEmployeeConverter();
		Employee emp = converter.convert(src);
		if (emp != null)
			System.out.println(emp.getUserName() + ":" + emp.getAge());
	}
}
