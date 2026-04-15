(function () {
  const statusDot = document.getElementById('statusDot');
  const statusText = document.getElementById('statusText');
  const statusDetails = document.getElementById('statusDetails');

  function setState(state, details) {
    if (!statusDot || !statusText || !statusDetails) {
      return;
    }

    statusDot.classList.remove('status__dot--up', 'status__dot--down');

    if (state === 'UP') {
      statusDot.classList.add('status__dot--up');
      statusText.textContent = 'API status: UP';
    } else if (state === 'DOWN') {
      statusDot.classList.add('status__dot--down');
      statusText.textContent = 'API status: DOWN';
    } else {
      statusText.textContent = 'Checking API status…';
    }

    statusDetails.textContent = details || '';
  }

  async function check() {
    const startedAt = Date.now();
    try {
      const res = await fetch('/api/health', {
        method: 'GET',
        headers: { 'Accept': 'application/json' }
      });

      if (!res.ok) {
        setState('DOWN', `HTTP ${res.status} • checked ${new Date().toLocaleString()}`);
        return;
      }

      const json = await res.json();
      const ms = Date.now() - startedAt;
      const app = json.applicationName ? ` • app: ${json.applicationName}` : '';
      const when = json.timestamp ? ` • at: ${new Date(json.timestamp).toLocaleString()}` : ` • checked: ${new Date().toLocaleString()}`;

      setState(String(json.status || 'UP').toUpperCase(), `~${ms}ms${app}${when}`);
    } catch (e) {
      setState('DOWN', `Network error • checked ${new Date().toLocaleString()}`);
    }
  }

  setState('CHECKING');
  check();
})();

