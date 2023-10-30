import axios from "axios"

export const getUser = async (setUserLog: Function, id: any, formData: any) => {

    await axios.put(
        `https://reparame-api.onrender.com/prestadores${id}`, {
        id: formData.id,
        category: formData.category,
        productName: formData.productName,
        itemCode: formData.itemCode,
        uniPrice: formData.uniPrice,
        quantityStock: formData.quantityStock,
    },
    )
        .then(function (response) {
            setUserLog(response.data)
        })
        .catch(function (err) {
            console.log(err);
        })
};
