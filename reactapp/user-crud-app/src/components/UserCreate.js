import React from 'react';
import axios from 'axios';
import UserForm from './UserForm';

const UserCreate = ({ navigate }) => {
  const createUser = async (user) => {
    try {
      await axios.post('http://localhost:8080/api/users', user);
      navigate('/');
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <h1>Criar Usuário</h1>
      <UserForm initialValues={{}} onSubmit={createUser} />
    </div>
  );
};

export default UserCreate;
