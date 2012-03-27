package net.slowvic.beetl;

import java.io.IOException;
import java.io.Writer;

import org.bee.tl.core.BeeException;
import org.bee.tl.core.Function;
import org.bee.tl.core.GroupTemplate;
import org.bee.tl.core.Template;
import org.springframework.util.StringUtils;

public class FunctionDefinition {
	/**
	 * 自定义函数
	 * 
	 * @param args
	 * @throws IOException
	 * @throws BeeException
	 */
	public static void main(String[] args) throws IOException, BeeException {
		GroupTemplate group = new GroupTemplate();
		group.registerFunction("capitalize", new Function() {

			public Object call(Object[] paramArrayOfObject,
					Template paramTemplate, Writer paramWriter) {
				String param = (String) paramArrayOfObject[0];
				return StringUtils.capitalize(param);
			}
		});
		String input = "get${capitalize(property)}";
		Template template = group.getStringTemplate(input);
		template.set("property", "userName");
		System.out.println(template.getTextAsString());
	}
}
