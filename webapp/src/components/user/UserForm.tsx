import {
    AppBar,
    Button,
    Container,
    Dialog, Fab,
    Grid,
    IconButton,
    Slide,
    TextField,
    Toolbar,
    Typography
} from "@mui/material";
import CloseIcon from "@mui/icons-material/Close";
import SaveAsIcon from "@mui/icons-material/SaveAs";
import React from "react";
import {TransitionProps} from "@mui/material/transitions";
import AddIcon from "@mui/icons-material/Add";

const Transition = React.forwardRef(function Transition(
    props: TransitionProps & {
        children: React.ReactElement;
    },
    ref: React.Ref<unknown>,
) {
    return <Slide direction="up" ref={ref} {...props} />;
});


export function UserForm() {
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = (e: any) => {
        console.log({e})
        setOpen(false);
    };

    return (
        <>
        <Fab variant="extended" size="medium" color="primary" aria-label="add" onClick={handleClickOpen} >
            <AddIcon sx={{ mr: 1 }} />
            add
        </Fab>
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
                        CREATE USER
                    </Typography>
                    <Button autoFocus color="inherit"  variant="outlined" onClick={handleClose}  startIcon={<SaveAsIcon />}>
                        Save
                    </Button>
                </Toolbar>
            </AppBar>
            <br />
            <Container maxWidth="md">
                <Grid container spacing={2} rowSpacing={2}>
                    <Grid item xs={8}>
                        <TextField fullWidth id="name"  label="Name"  />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField id="age" type="number" label="Age"/>
                    </Grid>
                    <Grid item xs={8}>
                        <TextField fullWidth id="street" label="Street" />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField id="number" label="Number" />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField id="zipcode" label="Zip Code" />
                    </Grid>
                </Grid>
            </Container>

        </Dialog>
        </>
    )
}