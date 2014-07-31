package players

class Metatron {
	static descr = 'All that we see is but a dream within a dream.'

	static bots = [
		// first one is default pick, 
		// so make it defensive
		players.Henny,

	        // players here
	        players.Yakko,

	        // dummy bots
	        players.Flat,
	        players.Foxtrot,
	        players.Paisley,
	        players.Pat,
	        players.Lisa,
	        players.Pie,
	        players.Bait,
	        players.Beatfreak,
	        players.DeBruijn,
	        players.Dunno,
	        players.Goldfish,
	        players.Rock,
	        players.Rot,
	        players.Shotgun
	]

	static hands = []
	static predictions = []

	static hand = { myhands, yourhands ->
		def beat = { hand ->
			(hand + 1) % 3
		}

		def updatePredictions = { predictions, hands ->
			[predictions, hands]
				.transpose()
				.collect({ tuple ->
					tuple[1] == yourhands.last() ? tuple[0] + 1 : tuple[0]
				})
		}

		def updateHands = { bots ->
			bots.collect({ bot ->
				// Ask all bots politely what they will do against me :)
				bot.hand(yourhands, myhands)
			})
		}

		def findBest = { predictions ->
			if (predictions.size() == 0) 0 else
			predictions.indexOf(predictions.max())
		}

		// Let's do this...
		if (yourhands.size() == 0) {
			// reset for new match
			hands = [0] * bots.size()
			predictions = [0] * bots.size()
		} else {
			predictions = updatePredictions(predictions, hands)
		}
		hands = updateHands(bots)
		beat(hands[findBest(predictions)])
	}
}
