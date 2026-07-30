import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
  const average = props.Total / props.goal * 100;

  return (
    <div className="scoreCard">
      <h2>Student Score Details</h2>
      <p>Name: {props.Name}</p>
      <p>School: {props.School}</p>
      <p>Total Score: {props.Total}</p>
      <p>Goal: {props.goal}</p>
      <p>Average Score: {average.toFixed(2)}%</p>
    </div>
  );
}

export default CalculateScore;
