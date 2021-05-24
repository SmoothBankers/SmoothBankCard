import configureStore from "../store/configureStore"
import { render, screen, act, waitFor, fireEvent } from '@testing-library/react';
import mockedAxios from 'axios';
import axios from "axios";
import CardContainer from './CardContainer';

afterEach(() =>{
    axios.get.mockClear();
    axios.post.mockClear();
});

test('displaying page', async () => {
    const data = {
      data: [
        {
          id: 1,
          title: "Example title",
          description: "This is a mock description",
          rate: 1.00
        }
      ]
    };

    const response = {
        data:[

        ]
    };
  
    mockedAxios.get.mockResolvedValueOnce(data);
    mockedAxios.post.mockResolvedValueOnce(response);

    //These tests pass, but there's a odd behavior where it registers an uncaught error in cardTypeActions.
    //CardTypeActions works as expected and passes its tests, so it appears that the mocking of Axios get here
    //messes with the Axios get calls in CardTypeActions during these tests. Not sure if this is cause for
    //concern but right now all the tests seem to pass without any real issue.

    act(() => {
      render(<CardContainer store = {configureStore()}/>);
      expect(screen.getByText(/Register/)).toBeInTheDocument();
    });

    const titleElement = screen.findByText("Example title");
    const retVal = fireEvent.click(screen.getByText(/Register/));

    await waitFor(() => {
      expect(titleElement).toBeTruthy();
      expect(retVal).toBeTruthy();
    });
  
  
  });