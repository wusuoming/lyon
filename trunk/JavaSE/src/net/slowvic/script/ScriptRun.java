package net.slowvic.script;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptRun {
	private ScriptEngine createEngine() {
		ScriptEngineManager manager = new ScriptEngineManager();
		return manager.getEngineByExtension("js");
	}

	public static void main(String[] args) throws ScriptException,
			NoSuchMethodException {
		ScriptRun sr = new ScriptRun();
		ScriptEngine engine = sr.createEngine();

		Bindings bindings = engine.createBindings();
		bindings.put("a", "3");
		bindings.put("b", "2");

		Object o = engine.eval("a*b", bindings);
		System.out.println(o);

		String function = "function pow(i){return Math.pow(i,2);}";
		engine.eval(function);
		Invocable invocable = (Invocable) engine;
		Object result = invocable.invokeFunction("pow", 3);
		System.out.println(result);
	}
}
