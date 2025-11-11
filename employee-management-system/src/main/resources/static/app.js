fetch('/api/employees')
  .then(response => response.json())
  .then(data => console.log(data));