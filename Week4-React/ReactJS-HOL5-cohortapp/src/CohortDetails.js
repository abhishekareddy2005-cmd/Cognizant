import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails(props) {
  const h3Style = {
    color: '#333',
    fontSize: '18px'
  };

  return (
    <div className={styles.box}>
      <h3 style={h3Style}>{props.name}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{props.status}</dd>
        <dt>Start Date</dt>
        <dd>{props.startDate}</dd>
        <dt>End Date</dt>
        <dd>{props.endDate}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
