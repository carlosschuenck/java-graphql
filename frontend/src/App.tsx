import React, {useEffect} from 'react';
import './App.css';

import {ApolloClient, gql, InMemoryCache} from "@apollo/client";


const client = new ApolloClient({
    uri: 'http://localhost:8080/user-service/graphql',
    cache: new InMemoryCache(),
});

function App() {

  function testing(){
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
        testing();
    }, []);


  return (
    <div className="App">
        <h1>OLÁ </h1>
    </div>
  );
}

export default App;
