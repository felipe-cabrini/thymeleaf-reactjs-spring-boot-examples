import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import UserList from './components/UserList';
import UserEdit from './components/UserEdit';
import UserCreate from './components/UserCreate';
import './styles.css';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<UserList />} />
        <Route path="/create" element={<UserCreate />} />
        <Route path="/edit/:id" element={<UserEdit />} />
      </Routes>
    </Router>
  );
};

export default App;