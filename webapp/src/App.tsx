import React from 'react';

import {Container, Divider} from "@mui/material";
import {UserList} from "./components/user/UserList";
import {Header} from "./components/Header";


function App() {



    return (

        <Container maxWidth="xl">
            <Header title="Users" />
            <Divider />
            <br />
            <UserList />

        </Container>
    );
}

export default App;
