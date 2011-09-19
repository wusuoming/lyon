package groovy;
/**
 * 声明一个变量并打印出来
 */
def str = "hello,wrold!"
println str
println str.class
str = 2
println str.class

/**
 * 声明一个方法，使用循环
 */
def repeat(var){
	for(i in 0..5){
		println var
	}
}
repeat(str) //调用方法

/**
 * GString的用法
 */
def i = 1
println "This is ${i}:${str}"

/**
 * groovy和Javascript一样不支持方法重载
 */
def defaultRepeat(var,defaultRepeat=2){
	for(i in 0..<defaultRepeat){
		println "this is ${i} of ${var}"
	}
}
defaultRepeat("2")

/**
 * 集合
 */
def collect = ["a","b","c"]
collect.add(1)
collect << 2;
collect[2] = "z"
for(el in collect){
	println el
}
println(collect[-1] == collect[collect.size()-1])
println collect.class
assert collect instanceof List