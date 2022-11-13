import React, {useEffect, useState} from 'react';
import './App.css';

import {gql, useMutation, useQuery} from "@apollo/client";

import {
    AppBar,
    Avatar, Button,
    Container,
    createTheme, Dialog, Divider,
    Grid,
    IconButton,
    Paper, Slide,
    styled, Typography,
    Toolbar
} from "@mui/material";
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import ListAltIcon from '@mui/icons-material/ListAlt';
import AddBoxOutlinedIcon from '@mui/icons-material/AddBoxOutlined';
import { TransitionProps } from '@mui/material/transitions';
import CloseIcon from "@mui/icons-material/Close";
import SaveAsIcon from "@mui/icons-material/SaveAs";

interface User {
    id: string;
    name: string;
    age: number;
}

interface UserData {
    users: User[];
}

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

const DELETE_USER = gql`
    mutation DeleteUser($id: ID!) {
        deleteUser(id: $id)
    }
`;

const Transition = React.forwardRef(function Transition(
    props: TransitionProps & {
        children: React.ReactElement;
    },
    ref: React.Ref<unknown>,
) {
    return <Slide direction="up" ref={ref} {...props} />;
});

function App() {
    const [deleteUser] = useMutation(DELETE_USER);
    const { data, refetch } = useQuery<UserData>(GET_USER);
    const [open, setOpen] = React.useState(false);

    const deleteUserAndUpdateList = async ({ id }: User) => {
        await deleteUser({variables: { id }});
        await refetch();
    }



    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = (e: any) => {
        console.log({e})
        setOpen(false);
    };


    return (

        <Container maxWidth="xl">
            <Grid container justifyContent="center" alignItems="center">
                <Grid item>
                    <Typography variant="h2"  align="center" gutterBottom>Users</Typography>
                </Grid>
                <Grid item>
                    <IconButton aria-label="add"
                                onClick={handleClickOpen}>
                        <AddBoxOutlinedIcon fontSize={"large"}/>
                    </IconButton>
                    <Dialog
                        fullScreen
                        open={open}
                        onClose={handleClose}
                        TransitionComponent={Transition}
                    >
                        <AppBar sx={{ position: 'relative' }}>
                            <Toolbar>
                                <IconButton
                                    edge="start"
                                    color="inherit"
                                    onClick={handleClose}
                                    aria-label="close"
                                >
                                    <CloseIcon />
                                </IconButton>
                                <Typography sx={{ ml: 2, flex: 1 }} variant="h6" component="div">
                                    NEW USER FORM
                                </Typography>
                                <Button autoFocus color="inherit"  variant="outlined" onClick={handleClose}  startIcon={<SaveAsIcon />}>
                                    Save
                                </Button>
                            </Toolbar>
                        </AppBar>
                        <h1>NAYARA SAFADA</h1>
                    </Dialog>
                </Grid>
            </Grid>


            <Divider />
            <br />
            <Grid container spacing={4} justifyContent="flex-start">
                {data && data.users.map((user) => (
                    <Grid item xs={2} key={user.id}>
                        <Paper elevation={4}>
                            <Grid container
                                  justifyContent="space-evenly"
                                  padding={2}
                                  flexWrap="wrap"
                                  rowSpacing={1.5}>
                                <Grid xs={12} item maxHeight={300} maxWidth={300}>
                                    <Avatar src="/images/man-avatar.png" sx={{ width: '100%', height: '100%' }}/>
                                </Grid>
                                <Grid xs={12} item>
                                    <Typography variant="h6"  align="center">{user.name}</Typography>
                                </Grid>
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
                                    <IconButton aria-label="delete" onClick={ async () => { await deleteUserAndUpdateList(user); }}>
                                        <DeleteIcon fontSize={"large"}/>
                                    </IconButton>
                                </Grid>
                            </Grid>
                        </Paper>
                    </Grid>
                ))}
            </Grid>
        </Container>
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
