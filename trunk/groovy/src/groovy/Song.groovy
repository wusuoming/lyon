package groovy

class Song {
    def name
    String artist
    def genre
    
    @Override
    def String toString() { //覆盖toString()方法
		"${name}是一首${getGenre()}风格的乐曲，由${artist}演奏" //默认返回最后一行
	}
    
    @Override
    getGenre(){
        genre?.toUpperCase(); //使用?对null检查
    }
}
