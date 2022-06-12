// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['I like boba', 'I like ice cream', 'I am a gamer', 'I am a professional figure skater'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}



async function addColors(){
    const responseFromServer = await fetch('/test');
    const textFromResponse = await responseFromServer.text();
    // Parse the response as JSON.
    const myObject = await responseFromServer.json();
    const colorContainer = document.getElementById('color-container');
    colorContainer.innerText = textFromResponse;
}

async function getColorQuotes(){
    const responseFromServer = await fetch('/test');
    const objectFromResponse = await responseFromServer.json();
    console.log(objectFromResponse);
    // Parse the response as JSON.
    
    const quotes = objectFromResponse[Math.floor(Math.random() * colors.length)];

    const quotesContainer = document.getElementById('color-container');
    quotesContainer.innerText = quotes;

}