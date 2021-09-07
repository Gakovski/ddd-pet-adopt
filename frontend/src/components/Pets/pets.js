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
import Link from '@material-ui/core/Link';
import petRepository from "../../repository/petRepository";

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
                </Toolbar>
            </AppBar>
            <main>
                <Container className={classes.cardGrid} maxWidth="lg">
                    {/* End hero unit */}
                    <Grid container spacing={5}>
                        {/*{props.pets.forEach((card) => (*/}
                        {props.pets.map((card)=> (
                            <Grid item key={card} xs={12} sm={6} md={4}>
                                <Card className={classes.card}>
                                    <CardMedia
                                        className={classes.cardMedia}
                                        //image="https://source.unsplash.com/random"
                                        //image="https://www.liveabout.com/thmb/w4u4Uuu10rotIlVXzVJwt2RQtnw=/560x410/filters:no_upscale():max_bytes(150000):strip_icc()/dog-smile-buzzfeed-58b8ed1d5f9b58af5c9c85c3.jpg"
                                        image={card.petImageUrl}
                                        title="Image title"
                                    />
                                            <CardContent className={classes.cardContent}>
                                                <Typography  gutterBottom variant="h5" component="h2">
                                                    {card.petName}
                                                </Typography>
                                                <Typography gutterBottom variant="h10" component="h5">
                                                    {card.petBreed}
                                                </Typography>
                                                <Typography>
                                                    {card.petDescription}
                                                </Typography>
                                            </CardContent>

                                        {card.isAdopted ? (
                                                <CardActions>
                                                    <Button size="small" variant="outlined" disabled>
                                                        Not available
                                                    </Button>
                                                </CardActions>

                                    ) : (
                                            <CardActions>
                                                <Button size="small" variant="outlined">
                                                    Adopt
                                                </Button>
                                            </CardActions>
                                    )}

                                </Card>
                            </Grid>
                        ))}
                    </Grid>
                </Container>
            </main>
            {/* Footer */}
            <footer className={classes.footer}>
                <Typography variant="h6" align="center" gutterBottom>
                    Footer
                </Typography>
                <Typography variant="subtitle1" align="center" color="textSecondary" component="p">
                    Something here to give the footer a purpose!
                </Typography>
                <Copyright />
            </footer>
            {/* End footer */}
        </React.Fragment>
    );
}

export default Pets;

//
// const pets = (props) => {
//     return(
//       <div className={"container mm-4 mt-5"}>
//           <div className={"row"}>
//               <div className={"row"}>
//                   <table className={"table table-striped"}>
//                       <thead>
//                       <tr>
//                           <th scope={"col"}>Pet Name</th>
//                           <th scope={"col"}>Pet Type</th>
//                           <th scope={"col"}>Pet Description</th>
//                           <th scope={"col"}>Pet Breed</th>
//                       </tr>
//                       </thead>
//                       <tbody>
//                       {props.pets.map((term)=>{
//                           return (
//                               <tr>
//                                   <td>{term.petName}</td>
//                                   <td>{term.petTypeName}</td>
//                                   <td>{term.petDescription}</td>
//                                   <td>{term.petBreed}</td>
//                               </tr>
//                           )
//                       })}
//                       </tbody>
//                   </table>
//               </div>
//           </div>
//       </div>
//     );
// }
//  export default pets;