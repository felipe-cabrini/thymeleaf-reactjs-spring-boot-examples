import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const UserForm = ({ initialValues, onSubmit }) => {
  const [name, setName] = useState(initialValues.name || '');
  const [email, setEmail] = useState(initialValues.email || '');
  const navigate = useNavigate();


  const handleSubmit = async (e) => {
    e.preventDefault();
    const user = { name, email };
    try {
        await axios.post('http://localhost:8080/api/users', user);
        navigate('/');
      } catch (error) {
        console.error('Error creating user:', error);
      }
  };

 
  return (
    <div>
      <h2>Formulário</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Nome:</label>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <div>
          <label>Email:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <button type="submit">Save</button>
      </form>
    </div>
  );
};

export default UserForm;
