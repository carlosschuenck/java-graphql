import {Grid, IconButton} from "@mui/material";
import ListAltIcon from "@mui/icons-material/ListAlt";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import React from "react";
import {useMutation} from "@apollo/client";
import {DELETE_USER} from "../../graphql/user/mutation";

type ListButtonOptionsType = {
    refreshList: Function
    userId: string
}

export function UserListItemActions(props: ListButtonOptionsType){
    const [deleteUser] = useMutation(DELETE_USER);

    const deleteUserAndUpdateList = async (id: string) => {
        await deleteUser({variables: { id }});
        await props.refreshList();
    }

    return (
        <>
        <Grid item>
            <IconButton aria-label="delete">
                <ListAltIcon fontSize={"large"}/>
            </IconButton>
        </Grid>
        <Grid item>
            <IconButton aria-label="edit">
                <EditIcon fontSize={"large"}/>
            </IconButton>
        </Grid>
        <Grid item>
            <IconButton aria-label="delete" onClick={ async () => { await deleteUserAndUpdateList(props.userId); }}>
                <DeleteIcon fontSize={"large"}/>
            </IconButton>
        </Grid>
        </>
    )
}