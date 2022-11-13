import {Grid, Paper} from "@mui/material";
import React from "react";
import {useQuery} from "@apollo/client";
import {UserListItemActions} from "./UserListItemActions";
import {UserListItemDetail} from "./UserListItemDetail";
import {GET_USER} from "../../graphql/user/query";

interface User {
    id: string;
    name: string;
    age: number;
}

interface UserData {
    users: User[];
}

export function UserList(){
    const { data, refetch } = useQuery<UserData>(GET_USER);

    return (
        <Grid container spacing={4} justifyContent="flex-start">
            {data && data.users.map((user) => (
                <Grid item xs={2} key={user.id}>
                    <Paper elevation={4}>
                        <Grid container
                              justifyContent="space-evenly"
                              padding={2}
                              flexWrap="wrap"
                              rowSpacing={1.5}>
                            <UserListItemDetail name={user.name} />
                            <UserListItemActions userId={user.id} refreshList={refetch} />
                        </Grid>
                    </Paper>
                </Grid>
            ))}
        </Grid>
    )
}