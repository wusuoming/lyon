var bounce = {
	x : 0,
	y : 0,
	w : 200,
	h : 200,
	dx : 5,
	dy : 5,
	interval : 100,
	win : null,
	timer : null,
	start : function() {
		bounce.x = (screen.width - bounce.w) / 2;
		bounce.y = (screen.height - bounce.h) / 2;
		bounce.win = window
				.open('javascript:"<h1>BOUNCE!</h1>","","left="+bounce.x+",top="+bounce.y'
						+ '+",width="+bounce.w+",height="+bounce.h+",status=yes"');
		bounce.timer = setInterval(bounce.nextFrame, bounce.interval);
	},
	stop : function() {
		clearInterval(bounce.timer);
		if (!bounce.win.closed)
			bounce.win.close();
	},
	nextFrame : function() {
		if (bounce.win.closed) {
			clearInterval(bounce.timer);
			return;
		}
		if ((bounce.x + bounce.dx > (screen.availWidth - bounce.w))
				|| (bounce.x + bounce.dx < 0))
			bounce.dx = -bounce.dx;
		if ((bounce.y + bounce.dy > (screen.availHeight - bounce.h))
				|| (bounce.y + bounce.dy < 0))
			bounce.dy = -bounce.dy;
		bounce.x += bounce.dx;
		bounce.y += bounce.dy;

		bounce.win.moveTo(bounce.x, bounce.y);
		bounce.win.defaultStatus = "(" + bounce.x + "," + bounce.y + ")";
	}
}