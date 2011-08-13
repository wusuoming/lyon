function Circle(radius) {
	this.radius = radius;
}

Circle.PI = 3.14159;

Circle.prototype.area = function() {
	return Math.pow(this.radius, 2) * Circle.PI;
}

Circle.max = function(a, b) {
	if (a.radius > b.radius) {
		return a;
	} else {
		return b;
	}
}