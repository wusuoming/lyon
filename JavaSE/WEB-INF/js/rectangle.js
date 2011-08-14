/** 长方形* */
function Rectangle(w, h) {
	this.width = w;
	this.height = h;
}

Rectangle.prototype.area = function() {
	return this.width * this.height;
}
/** ************************************* */

/** 带位置的长方形，继承Rectangle* */
function PositionedRectangle(x, y, w, h) {
	Rectangle.call(this, w, h);
	this.x = x;
	this.y = y;
}

PositionedRectangle.prototype = new Rectangle();

delete PositionedRectangle.prototype.width;
delete PositionedRectangle.prototype.height;

PositionedRectangle.prototype.constructor = PositionedRectangle;