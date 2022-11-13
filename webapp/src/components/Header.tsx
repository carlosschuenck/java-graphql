import {Grid, Typography} from "@mui/material";
import {UserForm} from "./user/UserForm";
import React from "react";

type HeaderType = {
    title: string
}

export function Header(props: HeaderType){
    return (
        <Grid container justifyContent="center" alignItems="center">
            <Grid item xs={11}>
                <Typography variant="h2"  align="center" gutterBottom>{props.title}</Typography>
            </Grid>
            <Grid item xs={0.5}>
                <UserForm />
            </Grid>
        </Grid>
    )
}