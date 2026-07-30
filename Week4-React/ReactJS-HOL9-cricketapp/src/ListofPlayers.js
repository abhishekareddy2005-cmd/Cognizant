import React from 'react';

function ListofPlayers() {
  const players = [
    { name: 'Rohit', score: 85 },
    { name: 'Virat', score: 92 },
    { name: 'Dhoni', score: 65 },
    { name: 'Sachin', score: 78 },
    { name: 'Dravid', score: 55 },
    { name: 'Sehwag', score: 90 },
    { name: 'Yuvraj', score: 45 },
    { name: 'Ganguly', score: 72 },
    { name: 'Kumble', score: 30 },
    { name: 'Zaheer', score: 25 },
    { name: 'Harbhajan', score: 40 }
  ];

  // map and filter using arrow functions
  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      {players.map((player, index) => (
        <p key={index}>{player.name} - Score: {player.score}</p>
      ))}

      <h2>Players with score below 70</h2>
      {lowScorers.map((player, index) => (
        <p key={index}>{player.name} - Score: {player.score}</p>
      ))}
    </div>
  );
}

export default ListofPlayers;
