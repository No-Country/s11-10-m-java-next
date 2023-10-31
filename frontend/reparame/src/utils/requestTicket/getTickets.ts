import axios from "axios";

export const getTickets = async (setTickets: Function) => {
  await axios
    .get(`https://reparame-api.onrender.com/tickets`)

    .then(function (response) {
      console.log(response);
      setTickets(response.data);
    })
    .catch(function (err) {
      console.log(err);
    });
};
