def thePlayers = [
	// players here
	players.Yakko,
	players.Santa,
	players.Faisal,
	players.Fubar,

	// cheatbots
//	players.Matthew,
//	players.Metatron,

	// dummy bots
	players.Bait,
	players.Beatfreak,
	players.DeBruijn,
	players.Dunno,
	players.Flat,
	players.Foxtrot,
	players.Goldfish,
	players.Henny,
	players.Lisa,
	players.Paisley,
	players.Pat,
	players.Pie,
	players.Rock,
	players.Rot,
	players.Shotgun
]

def rounds = 1000
def size = thePlayers.size()
def indices = 0 ..< size
def grid = ([0] * size * size).collate(size)

def playMatch = { player1, player2 ->
	(1 .. rounds)
		.inject([[], []], { hands, ignore ->
			def hands1 = hands[0]
			def hands2 = hands[1]

			def hand1 = player1.hand(hands1, hands2) % 3
			def hand2 = player2.hand(hands2, hands1) % 3

			[hands1 + hand1, hands2 + hand2]
		})
}

def playTournament = { players ->
	indices.collect({ index1 ->
		indices.collect({ index2 ->
			// only play top-right diagonal half
			if (index1 >= index2) 0 else
			playMatch(players[index1], players[index2])
		})
	})
}

def scoreHand = { hands ->
	(hands[0] - hands[1] + 4) % 3 - 1
}

def add = { x, y ->
	x + y
}

def scoreMatch = { hands ->
	if (hands == 0) 0 else
	hands
		.transpose()
		.collect(scoreHand)
		.inject(add)
}

def scoreMatches = { tournament ->
	for (x in indices) {
		for (y in indices) {
			if (x < y)
				grid[x][y] = scoreMatch(tournament[x][y])
			else if (x > y)
				grid[x][y] = -grid[y][x]
		}
	}
	grid
}

def rankTournament = { tournament ->
	tournament.collect({ player ->
		player.inject(add)
	})
}

def scoreTournament = { players, tournament ->
	def scores = scoreMatches(tournament)
	def totals = [indices, rankTournament(scores), players]
		.transpose()
		.sort({ a, b -> b[1] <=> a[1]})
		.transpose()
	def order = totals[0]
	def ranks = totals[1]
	def orderedPlayers = totals[2]

	def newscores = order.collect({ x ->
		order.collect({ y ->
			if (x==y) 'x' else
			scores[x][y]
		})
	})

	[orderedPlayers, ranks, newscores]
		.transpose()
}

def prettyLine = { line ->
	line[0].name.split('\\.')[1].padRight(16) + 
	line[1].toString().padLeft(8) + 
	line[2].collect({ item ->
		item.toString().padLeft(6)
	})
	.join('')
}

def printTournament = { tournament ->
	'name               score' +
	indices.collect({ index -> (index + 1).toString().padLeft(6)}).join('') +
	'\n' +
	tournament
		.collect(prettyLine)
		.join('\n')
}

def tournament = playTournament(thePlayers)
println('Backbase RoShamBo Tournament results\n')
println(printTournament(scoreTournament(thePlayers, tournament)))
