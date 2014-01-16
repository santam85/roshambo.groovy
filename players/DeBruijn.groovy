package players

class DeBruijn {
	static len = 7
	static descr = 'So unpredictable it becomes predictable'

	static hand = { myhands, yourhands ->
		if (myhands.size() < len) 0 else {
			def seq = myhands
				.drop(myhands.size() - len)

			// almost DeBruijn - no 2222222
			(seq.first() + seq.last() + 1) % 3
		}
	};
};
