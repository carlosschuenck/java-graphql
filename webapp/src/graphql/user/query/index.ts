import {gql} from "@apollo/client";

const GET_USER = gql`
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

export {
    GET_USER
}