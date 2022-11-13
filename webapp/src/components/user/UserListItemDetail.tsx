import {Avatar, Grid, Typography} from "@mui/material";
import React from "react";

type ListItemDetailType = {
    name: string
}
export function UserListItemDetail(props: ListItemDetailType) {
    return (
        <>
            <Grid xs={12} item maxHeight={300} maxWidth={300}>
                <Avatar src="/images/man-avatar.png" sx={{ width: '100%', height: '100%' }}/>
            </Grid>
            <Grid xs={12} item>
                <Typography variant="h6"  align="center">{props.name}</Typography>
            </Grid>
        </>
    )
}