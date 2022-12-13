import React from "react";
import { fireEvent, render , screen} from "@testing-library/react";
import App from '../App'
import Calculator from "../Calculator";

it('should render Calculator component in app', () => {
    render(<App/>)
    expect(screen.getByText(/Display Result/i)).toBeDefined();
})

it('should the calculator component', () => {
    render(<Calculator/>)
    expect(screen.getByText(/Display Result/i)).toBeDefined();
})

it('should set first operand', () => {
    const setStateMock = jest.fn();
    const useStateMock = (useState) => [useState, setStateMock]
    jest.spyOn(React, 'useState').mockImplementation(useStateMock)
    
    render(<Calculator/>);
    
    const number = screen.getByTestId("1");
    fireEvent.click(number)
    expect(setStateMock).toBeCalledWith("1")
})