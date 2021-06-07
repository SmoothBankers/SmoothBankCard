import React, {Component, createRef} from 'react';
import Joi from 'joi-browser';
//import axios from 'axios';

class LoanRegistration extends Component{

    state = {
        loan:{},
        holder:{
            name: "",
            home_phone:"",
            cell_phone:"",
            work_phone:"",
            email:"",
            ssn:"",
            address:"",
            zipcode:"",
            monthly_income:""
        },
        errors:{}
    };

    checkbox

    componentDidMount(){
        this.checkbox = createRef();
    }

    schema = {
        name: Joi.string().required().label("Your name"),
        email: Joi.string().required().email({minDomainAtons: 2}).label("Email"),
        home_phone: Joi.string().min(7).label("Home Phone")
        //TODO Add the rest
    };

    validate = () => {
        const options = {abortEarly: false};
        const { error } = Joi.validate(this.state.holder, this.schema, options)
        if (!error) return null;

        const errors = {};
        for(let item of error.detail){
            errors[item.path[0]] = item.message;
        }
        return errors;
    }

    validateField = ({name, value}) => {
        const obj = { [name]:value};
        const schema = {[name]: this.schema[name]}
        const {error} = Joi.validate(obj, schema);
        return error? error.details[0].message : null;
    }

    handleSubmit = async e => {
        //This code taken largely from RegisterUser.js, so any questions on how it works or why something
        //is the way that it is should be directed to Saif Zahedi
        e.preventDefault();

        const errors = this.validate();
        this.setState({errors:errors || {} });
        if (errors) return;

        try{
            const payload = {...this.state.holder};
            delete payload.confirmPass;
            //const {data} = await axios.post(/**API Backend for Loan registration**/'', payload);
            //Data will contain the results of the axios post, such as any tokens or data

            /**
             * localStorage.setItem("username", data.username);
             * localStorage.setItem("token", data.token);
             * window.location = '/success';
             */
        } catch(ex){
            if(ex.response && ex.response.status === 400){
                const errorMessage = "There is already a loan under your name";
                const errors = {...this.state.errors};
                errors.message = errorMessage;
                this.setState({errors});
            }
        }
    }

    handleChangeWithValidation = ({currentTarget: input}) => {
        const errors = {...this.state.errors};
        const errorMessage = this.validateField(input);
        if(errorMessage){
            errors[input.name] = errorMessage;
        } else {
            delete errors[input.name]
        }
        const holder = {...this.state.holder};
        holder[input.name] = input.value;
        this.setState({holder, errors});
    }

    handleChange = ({currentTarget: input}) => {
        const holder = {...this.state.holder};
        holder[input.name] = input.value;
        this.setState({holder});
    }

    handleBlur = ({currentTarget: input}) => {
        const errors = {...this.state.errors};
        const errorMessage = this.validateField(input);
        if(errorMessage) {
            errors[input.name] = errorMessage;
        } else {
            delete errors[input.name];
        }

        this.setState({errors});
    }

    handleTerms = () => {
        const errors = {...this.state.errors};
        if(!this.checkbox.current?.checked){
            errors['item'] = "You must agree to the Terms of Service";
        } else {
            delete errors['item'];
        }

        this.setState({errors});
    }

    

    render() {

        const spanStyle = {
            marginBottom:0,
            position: 'absolute'
        }

        return(
            <div className="row">
                <div className="mt-f offset-2 col-5">
                    <h1> Loan Registration</h1>
                    <form onSubmit={this.handleSubmit}>
                        <div className="row mt-5">
                            <label className="col-3 col-form-label" htmlFor="name">Legal Name:</label>
                            <div className="col-5">
                                <input
                                    value={this.state.holder.name}
                                    onChange={this.handleChangeWithValidation}
                                    onBlur={this.handleBlur}
                                    name="name"
                                    id="name" type="text" className="form-control" />
                                    <span style={spanStyle} className="text-danger">{this.state.errors.name}</span>
                            </div>
                        </div>
                        <div className="row mt-5">
                            <label className="col-3 col-form-label" htmlFor="email">Email:</label>
                            <div className="col-5">
                                <input
                                    value={this.state.holder.email}
                                    onChange={this.handleChangeWithValidation}
                                    onBlur={this.handleBlur}
                                    name="email"
                                    id="email" type="text" className="form-control" />
                                    <span style={spanStyle} className="text-danger">{this.state.errors.email}</span>
                            </div>
                        </div>
                        <div className="row mt-5">
                            <label className="col-3 col-form-label" htmlFor="home_phone">Home phone:</label>
                            <div className="col-5">
                                <input
                                    value={this.state.holder.home_phone}
                                    onChange={this.handleChangeWithValidation}
                                    onBlur={this.handleBlur}
                                    name="home_phone"
                                    id="home_phone" type="text" className="form-control" />
                                    <span style={spanStyle} className="text-danger">{this.state.errors.home_phone}</span>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        )

    }

}

export default LoanRegistration;