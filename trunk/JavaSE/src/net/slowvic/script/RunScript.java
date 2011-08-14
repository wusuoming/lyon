package net.slowvic.script;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RunScript {
	public static void main(String[] args) throws IOException, ScriptException {
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByExtension("js");
		Bindings bindings = engine.createBindings();
		String fileName = null;
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			if (arg.startsWith("-D")) {
				int pos = arg.indexOf("=");
				if (pos == -1) {
					usage();
				}
				String name = arg.substring(2, pos);
				String value = arg.substring(pos + 1);
				bindings.put(name, value);
			} else {
				if (fileName != null) {
					usage();
				}
				fileName = arg;
			}
		}
		if (fileName == null) {
			usage();
		}
		bindings.put(ScriptEngine.FILENAME, fileName);

		Reader in = new FileReader(fileName);
		Object result = engine.eval(in);
		System.out.println(result);
	}

	private static void usage() {
		System.err.println("Usage:java RunScript [-Dname=value...] script.js");
		System.exit(1);
	}
}
