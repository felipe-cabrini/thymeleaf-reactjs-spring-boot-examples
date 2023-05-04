import React, { useEffect, useState } from 'react';
import axios from 'axios';
import UserForm from './UserForm';
import { useParams } from 'react-router-dom';


const UserEdit = ({ match, history }) => {
  const [user, setUser] = useState(null);
  const { id } = useParams();


  useEffect(() => {
    fetchUser();
  }, []);

  const fetchUser = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/users/${id}`
      );
      setUser(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const updateUser = async (updatedUser) => {
    try {
      await axios.put(
        `http://localhost:8080/api/users/${match.params.id}`,
        updatedUser
      );
      history.push('/');
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <h1>Editar Usuário</h1>
      {user ? (
        <UserForm initialValues={user} onSubmit={updateUser} />
      ) : (
        <p>Carregando...</p>
      )}
    </div>
  );
};

export default UserEdit;
