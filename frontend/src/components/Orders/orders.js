import React from 'react';
import CardActions from "@material-ui/core/CardActions";
import Button from "@material-ui/core/Button";


const orders = (props) => {
    var numberOfOrders = 0;
    return(
      <div className={"container mm-4 mt-5"}>
          <div className={"row"}>
              <div className={"row"}>
                  <table className={"table"}>
                      <thead>
                      <tr>
                          <th scope={"col"}>Order</th>
                          <th scope={"col"}>Pet Info</th>
                          <th scope={"col"}>Adopter Info</th>
                          <th scope={"col"}>Order Status</th>
                      </tr>
                      </thead>
                      <tbody>
                      {props.orders.map((term)=>{
                          numberOfOrders = numberOfOrders + 1;
                          return (
                              <tr>
                                  <td>{numberOfOrders}</td>
                                  <td>
                                  <table className={"table table-striped"}>
                                      <tbody>
                                      <tr><td>Name: {term.pet.petName}</td></tr>
                                      <tr><td>Breed: {term.pet.petBreed}</td></tr>
                                      <tr><td>Description: {term.pet.petDescription}</td></tr>
                                      <tr><td>Status: {term.pet.isAdopted.toString()}</td></tr>
                                      </tbody>
                                  </table>
                                  </td>
                                  <td>
                                      <table className={"table table-striped"}>
                                          <tbody>
                                          <tr><td>Name: {term.adopter.adopterName}</td></tr>
                                          <tr><td>Surname: {term.adopter.adopterSurname}</td></tr>
                                          <tr><td>Email: {term.adopter.adopterEmail}</td></tr>
                                          <tr><td>Phone: {term.adopter.adopterPhone}</td></tr>
                                          </tbody>
                                      </table>
                                  </td>
                                  <td>
                                      {term.isApproved ? (
                                          <CardActions>
                                              <Button size="big" variant="contained" disabled>
                                                  Approved
                                              </Button>
                                          </CardActions>
                                      ) : (
                                          <CardActions>
                                              <Button size="big" variant="contained" color="primary"
                                              onClick={() => props.approveOrder(term.orderId.id)}>
                                                  Ready to Approve
                                              </Button>
                                          </CardActions>
                                      )}
                                  </td>
                              </tr>
                          )
                      })}
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
    );
}
 export default orders;