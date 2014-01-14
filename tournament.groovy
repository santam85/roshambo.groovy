def thePlayers = [
	players.Beatfreak,
	players.Dunno,
	players.Rock,
	players.Player1
]

def rounds = 1000

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

// double round-robin for now?
def playTournament = { players ->
	players.collect({ player1 ->
		players.collect({ player2 ->
			playMatch(player1, player2)
		})
	})
}

def scoreHand = { hand1, hand2 ->
	(hand1 - hand2 + 4) % 3 - 1
}

def add = { x, y ->
	x + y
}

def scoreMatch = { hands1, hands2 ->
	[hands1, hands2]
		.transpose()
		.collect({ hand ->
			scoreHand(hand[0], hand[1])
		})
		.inject(add)
}

def scoreTournament = { tournament ->
	tournament.collect({ player ->
		player.collect({ match ->
			scoreMatch(match[0], match[1])
		})
	})
}

def rankTournament = { tournament ->
	tournament.collect({ player ->
		player.inject(add)
	})
}

def getTournamentResults = { players ->
	def tournament = scoreTournament(playTournament(players))
	[players, rankTournament(tournament), tournament]
		.transpose()
		.sort({ a, b -> a[1] <=> b[1]})
		.reverse()
}

def prettyLine = { line ->
	line[0].name.split('\\.')[1].padRight(16) + 
	line[1].toString().padRight(8) + 
	line[2].collect({ item ->
		item.toString().padRight(6)
	})
	.join('')
}

def printTournament = { tournament ->
	'name            score   1     2     3    4\n' +
	tournament
		.collect(prettyLine)
		.join('\n')
}

println('Backbase RoShamBo Tournament results\n')
println(printTournament(getTournamentResults(thePlayers)))
