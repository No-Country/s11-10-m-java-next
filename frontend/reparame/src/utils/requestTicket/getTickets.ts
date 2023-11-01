import axios from "axios";

export const getTickets = async (setTickets: Function) => {
  const tokenKey = localStorage.getItem("tKeyId");
  await axios
    .get(`https://reparame-api.onrender.com/tickets`, {
      headers: {
        Authorization: `Bearer ${tokenKey}`,
      },
    })

    .then(function (response) {
      console.log(response);
      setTickets(response.data);
    })
    .catch(function (err) {
      console.log(err);
    });
};
