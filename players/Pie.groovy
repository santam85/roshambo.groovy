package players

class Pie {
	static descr = 'Mmmmm, pie'

	static pi = Math.PI
			.toString()
			.split('')
			.findAll({ x -> x >= '0' & x <= '9' })
			.tail()		// split leaves an empty '' at the beginning
			.collect({ x -> x.toInteger() })

	static hand = { myhands, yourhands ->
		pi[myhands.size() % pi.size()] % 3
	};
};
