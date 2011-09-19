package groovy
/**
 * 集合上的join、count、-、
 */
def numbers = [2,5,6,1,4,3,5,1]
println numbers.join(",")
println numbers.count(5)
numbers = numbers - [5,6] //重复元素也会被删除
println numbers.join(",")
numbers = numbers*+2 //复制N-1个元素追加到末端
println numbers.join(",")
println numbers.class

/**
 * 映射
 */
def name = "xingming"
def hash = [name:"slowvic","gender":"male"]
println hash.name //注意这里的name，是属性
hash.put("age", 25)
println hash.age
hash.major = "NetWork Engineering"
println hash.get("major")
println hash.getClass() //映射无法使用class，对应的Java类是LinkedHashMap

/**
 * 闭包
 */
numbers.each {value ->
	print(value)
}

hash.each { key,value ->
	println("${key}:${value}")	
}
