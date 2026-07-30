import React from 'react';

function App() {
  const offices = [
    { id: 1, name: 'Downtown Office', rent: 45000, address: '123 MG Road, Bangalore' },
    { id: 2, name: 'Tech Park Office', rent: 75000, address: '456 Whitefield, Bangalore' },
    { id: 3, name: 'Startup Hub', rent: 55000, address: '789 Koramangala, Bangalore' },
    { id: 4, name: 'Premium Suite', rent: 90000, address: '321 UB City, Bangalore' }
  ];

  return (
    <div>
      <h1>Office Space Rental</h1>
      <img
        src="https://via.placeholder.com/400x200"
        alt="Office Space"
        style={{ width: '400px', height: '200px' }}
      />

      <h2>Available Offices</h2>
      {offices.map(office => (
        <div key={office.id} style={{ border: '1px solid #ccc', margin: '10px', padding: '10px' }}>
          <h3>{office.name}</h3>
          <p>Address: {office.address}</p>
          <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
            Rent: ₹{office.rent}
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;
