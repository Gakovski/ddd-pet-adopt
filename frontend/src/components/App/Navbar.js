import React from 'react';
import AppBar from '@material-ui/core/AppBar';
import Button from '@material-ui/core/Button';
import PetsIcon from '@material-ui/icons/Pets';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import {Link} from 'react-router-dom';
import petRepository from "../../repository/petRepository";
import data from "bootstrap/js/src/dom/data";

function Copyright() {
    return (
        <Typography variant="body2" color="textSecondary" align="center">
            {'Copyright © '}
            <Link color="inherit" href="https://material-ui.com/">
                Your Website
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}

const useStyles = makeStyles((theme) => ({
    icon: {
        marginRight: theme.spacing(2),
    },
    heroContent: {
        backgroundColor: theme.palette.background.paper,
        padding: theme.spacing(8, 0, 6),
    },
    heroButtons: {
        marginTop: theme.spacing(4),
    },
    cardGrid: {
        paddingTop: theme.spacing(8),
        paddingBottom: theme.spacing(8),
    },
    card: {
        height: '100%',
        display: 'flex',
        flexDirection: 'column',
    },
    cardMedia: {
        paddingTop: '56.25%', // 16:9
    },
    cardContent: {
        flexGrow: 1,
    },
    footer: {
        backgroundColor: theme.palette.background.paper,
        padding: theme.spacing(6),
    },
}));
function test(data) {
    return data.id.id;
}
const cards = [1, 2, 3, 4, 5, 6, 7, 8, 9];

function Pets(props) {
    const classes = useStyles();
    return (
        <React.Fragment>
            <CssBaseline />
            <AppBar position="relative">
                <Toolbar>
                    <PetsIcon className={classes.icon} />
                    <Typography variant="h6" color="inherit" noWrap>
                        PET ADOPT WEBAPP
                    </Typography>

                    <CardActions >
                        <Button variant="contained" color="default" href="/pets">
                            Pet Catalog
                        </Button>
                    </CardActions>

                    <CardActions >
                        <Button variant="contained" color="default" href="/orders">
                            Orders
                        </Button>
                    </CardActions>

                    <CardActions >
                        <Button variant="contained" color="default" href="/pets/add">
                            Add New Pet
                        </Button>
                    </CardActions>



                </Toolbar>
            </AppBar>
        </React.Fragment>
    );
}

export default Pets;

