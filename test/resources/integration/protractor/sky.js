describe('sky homepage navigation', function() {
  it('should check a box and navigate away', function() {
    browser.get('http://localhost:9000');

	checkbox = element(by.css("label[for='1']"));

	checkbox.click();

  });
});
