import React, {useEffect} from 'react';
import './App.css';

import {ApolloClient, gql, InMemoryCache, useQuery} from "@apollo/client";
import {Box, Button, createTheme, Grid, Paper, styled, ThemeProvider} from "@mui/material";


const client = new ApolloClient({
    uri: 'http://localhost:8080/user-service/graphql',
    cache: new InMemoryCache(),
});


interface User {
    id: string;
    name: string;
    age: number;
}

const GET_ROCKET_INVENTORY = gql`
  query GetUser {
    users {
        id
        name
        age
        address {
            id
            number
            street
            zipCode
        }
        orders {
            id
            description
            userId
        }
    }
  }
`;

function App() {

  function Testing(){
      const { loading, data } = useQuery(GET_ROCKET_INVENTORY);
      console.log("use query",data)

      client.query({
          query: gql`
              query GetUser {
                  users {
                      id
                      name
                      age
                      address {
                          id
                          number
                          street
                          zipCode
                      }
                      orders {
                          id
                          description
                          userId
                      }
                  }
              }
          `
      }).then(result => console.log("RESULT", result))
      .catch(err => console.error("erro", err))
  }

    useEffect(() => {
        Testing();
    }, []);


  return (
    <div className="App">
        <h1>OLÁ APP</h1>
        <Grid container spacing={2}>
            <Grid item xs={12}>
                <ThemeProvider  theme={lightTheme}>
                    <Box
                        sx={{
                            p: 2,
                            bgcolor: 'background.default',
                            display: 'grid',
                            gridTemplateColumns: { md: '1fr 1fr' },
                            gap: 2,
                        }}
                    >
                        {[0, 1, 2, 3, 4, 6, 8, 12, 16, 24].map((elevation) => (
                            <Item key={elevation} elevation={elevation}>
                                {`elevation=${elevation}`}
                            </Item>
                        ))}
                    </Box>
                </ThemeProvider>
            </Grid>
        </Grid>
        <Button variant="contained"> Olá Mundo</Button>
    </div>
  );
}

const lightTheme = createTheme({ palette: { mode: 'light' } });

const Item = styled(Paper)(({ theme }) => ({
    ...theme.typography.body2,
    textAlign: 'center',
    color: theme.palette.text.secondary,
    height: 60,
    lineHeight: '60px',
}));


export default App;
