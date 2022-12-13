import React from 'react'
import { useState } from 'react'
import './Calculator.css'
import axios from 'axios'

const Calculator = () => {
    let numbers = [1,2,3,4,5,6,7,8,9,0]
    let operators = ["*", '/', '-' , '+', '**', 'log', 'ln']
    let [selectedFirstOperand, setSelectedFirstOperand] = useState(null)
    let [selectedSecondOperand, setSelectedSecondOperand]= useState(null)
    let [selectedOperator, setSelectedOperator] = useState(null)

    let setOperand = (number) => {
        if(!selectedFirstOperand)
            setSelectedFirstOperand(number)
        else setSelectedSecondOperand(number)
    }

    let calculate = async() => {
        let data = {operand1: selectedFirstOperand, operand2: selectedSecondOperand, operation: selectedOperator}
        let result = await axios.post('http://localhost:8080/api/v1/calculate', data, {
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
            },
        })
        console.log(result)
    }
    return ( 
        <> 
        <div className="screen">
            <div>{selectedFirstOperand}</div>
            <div>{selectedOperator}</div>
            <div>{selectedSecondOperand}</div>
        </div>
        <div className='calculator'>
            <div className="numbers">
                {numbers.map((number, index) => (
                    <div className='number' onClick={() => {setOperand(number)}}>{number}</div>
                ))}
            </div>
            <div className="operations-container">
                <div className='operators'>
                {operators.map((operator, index) => (
                    <div className='operator' onClick={() => setSelectedOperator(operator)}>{operator}</div>
                ))}
                </div>
                <div className="submit" onClick={() => calculate()}>Display Result</div>
            </div>
        </div>
        </>
     );
}
 
export default Calculator;