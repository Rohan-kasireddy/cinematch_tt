
import React, { useEffect, useState } from "react";
import axios from "axios";

export default function App() {
  const [movies, setMovies] = useState([]);
  const [query, setQuery] = useState("");
  const [loading, setLoading] = useState(false);
  const [user, setUser] = useState(null);
  const [isRegistering, setIsRegistering] = useState(false);
  const [authForm, setAuthForm] = useState({ username: "", password: "" });

  const fetchMovies = (q = "") => {
    setLoading(true);
    const base = "http://localhost:8081/api/movies";
    const url = q.trim() ? `${base}/search?q=${encodeURIComponent(q.trim())}` : `${base}`;

    axios
      .get(url)
      .then((res) => setMovies(res.data))
      .finally(() => setLoading(false));
  };

  useEffect(() => {
    fetchMovies();
  }, []);

  const handleSearch = (evt) => {
    evt.preventDefault();
    fetchMovies(query);
  };

  const login = (evt) => {
    evt.preventDefault();
    if (!authForm.username || !authForm.password) return;
    setUser({ username: authForm.username });
    setAuthForm({ username: "", password: "" });
  };

  const register = (evt) => {
    evt.preventDefault();
    if (!authForm.username || !authForm.password) return;
    // Real app: call /api/auth/register
    setUser({ username: authForm.username });
    setAuthForm({ username: "", password: "" });
  };

  if (!user) {
    return (
      <div style={{ background: "#0f172a", color: "#e2e8f0", minHeight: "100vh", padding: "40px" }}>
        <h1 style={{ marginBottom: "20px" }}>CineMatch Login</h1>
        <div style={{ maxWidth: "400px", margin: "0 auto", background: "#1e293b", borderRadius: "12px", padding: "20px" }}>
          <h2>{isRegistering ? "Register" : "Sign in"}</h2>
          <form onSubmit={isRegistering ? register : login}>
            <label style={{ display: "block", marginBottom: "10px" }}>
              Username:
              <input
                value={authForm.username}
                onChange={(e) => setAuthForm((p) => ({ ...p, username: e.target.value }))}
                style={{ width: "100%", padding: "8px", marginTop: "4px", borderRadius: "6px", border: "1px solid #334155" }}
              />
            </label>
            <label style={{ display: "block", marginBottom: "10px" }}>
              Password:
              <input
                type="password"
                value={authForm.password}
                onChange={(e) => setAuthForm((p) => ({ ...p, password: e.target.value }))}
                style={{ width: "100%", padding: "8px", marginTop: "4px", borderRadius: "6px", border: "1px solid #334155" }}
              />
            </label>
            <button
              type="submit"
              style={{ width: "100%", marginTop: "12px", padding: "10px", background: "#2563eb", color: "white", borderRadius: "8px", border: "none", cursor: "pointer" }}
            >
              {isRegistering ? "Create Account" : "Log In"}
            </button>
          </form>
          <p style={{ marginTop: "12px", textAlign: "center" }}>
            {isRegistering ? "Already have an account?" : "New user?"}{" "}
            <button
              onClick={() => setIsRegistering((s) => !s)}
              style={{ background: "transparent", border: "none", color: "#93c5fd", cursor: "pointer", textDecoration: "underline" }}
            >
              {isRegistering ? "Sign in" : "Register"}
            </button>
          </p>
        </div>
      </div>
    );
  }

  return (
    <div style={{ background: "#020617", color: "#f8fafc", minHeight: "100vh", padding: "20px" }}>
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: "20px", flexWrap: "wrap" }}>
        <h1 style={{ margin: 0 }}>CineMatch 🎬</h1>
        <div style={{ display: "flex", alignItems: "center", gap: "10px" }}>
          <span>Welcome, {user.username}</span>
          <button
            onClick={() => setUser(null)}
            style={{ background: "#ef4444", border: "none", color: "white", padding: "8px 12px", borderRadius: "8px", cursor: "pointer" }}
          >
            Logout
          </button>
        </div>
      </div>

      <form onSubmit={handleSearch} style={{ marginBottom: "20px", display: "flex", gap: "8px", flexWrap: "wrap" }}>
        <input
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          placeholder="Search movies by title..."
          style={{ flexGrow: 1, minWidth: "220px", padding: "10px", borderRadius: "8px", border: "1px solid #334155" }}
        />
        <button type="submit" style={{ padding: "10px 16px", borderRadius: "8px", background: "#10b981", border: "none", color: "white", cursor: "pointer" }}>
          Search
        </button>
        <button
          type="button"
          onClick={() => {
            setQuery("");
            fetchMovies();
          }}
          style={{ padding: "10px 16px", borderRadius: "8px", background: "#64748b", border: "none", color: "white", cursor: "pointer" }}
        >
          Reset
        </button>
      </form>

      {loading ? (
        <p>Loading movies…</p>
      ) : (
        <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fit, minmax(220px, 1fr))", gap: "16px" }}>
          {movies.map((m) => (
            <div key={m.id} style={{ background: "#1a202c", borderRadius: "10px", overflow: "hidden", boxShadow: "0 6px 15px rgba(0,0,0,0.3)", padding: "14px" }}>
              <h3 style={{ margin: "0 0 8px", color: "#38bdf8" }}>{m.title}</h3>
              <p style={{ margin: "4px 0", color: "#cbd5e1" }}>{m.genre} · {m.language} · {m.country}</p>
              <p style={{ margin: "4px 0", color: "#a5b4fc" }}>OTT: {m.ott}</p>
            </div>
          ))}
        </div>
      )}

      {movies.length === 0 && !loading && <p>No movies found. Try another search term.</p>}
    </div>
  );
}

