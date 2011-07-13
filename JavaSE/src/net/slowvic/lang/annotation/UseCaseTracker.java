package net.slowvic.lang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface UseCase {
	// id��description�Ǹ�ע���Ԫ�أ�������ʽͬ����������Ψһ�Ĳ�ͬ����������������һ��Ĭ��ֵ
	public int id();

	public String description() default "no description";
}

class PwdUtils {
	@UseCase(id = 47, description = "��������Ӧ����һ������")
	public boolean validatePwd(String pwd) {
		return (pwd.matches("\\w*\\d\\w*"));
	}

	@UseCase(id = 48)
	public String encryptPwd(String pwd) {
		return new StringBuilder(pwd).reverse().toString();
	}
}

public class UseCaseTracker {
	public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
		for (Method m : cl.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if (uc != null) {
				System.out.println("Found UseCase: id=" + uc.id()
						+ ",description: " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for (int i : useCases) {
			System.out.println("Warning: missing use Case-" + i);
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 47, 48, 49);
		trackUseCases(list, PwdUtils.class);
	}
}