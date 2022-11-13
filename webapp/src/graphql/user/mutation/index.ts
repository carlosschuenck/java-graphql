import {gql} from "@apollo/client";

const DELETE_USER = gql`
    mutation DeleteUser($id: ID!) {
        deleteUser(id: $id)
    }
`;


export {
    DELETE_USER
}