import { useEffect, useState } from "react";
import { api } from "../services/api";
import Player from "../components/Player";
import CountrySelect from "../components/CountrySelect";

type Channel = {
    name: string;
    logo: string;
    streamUrl: string;
    group?: string;
};

export default function Channels() {
    const [channels, setChannels] = useState<Channel[]>([]);
    const [current, setCurrent] = useState<string | null>(null);
    const [country, setCountry] = useState("in");

    useEffect(() => {
        setChannels([]);
        setCurrent(null);

        api.get(`/api/channels/${country}`).then(res => {
            setChannels(res.data);
            if (res.data.length > 0) {
                setCurrent(res.data[0].streamUrl);
            }
        });
    }, [country]);

    return (
        <div style={{ display: "flex", height: "100vh" }}>
            {/* Sidebar */}
            <div
                style={{
                    width: 320,
                    background: "#111",
                    color: "#fff",
                    display: "flex",
                    flexDirection: "column"
                }}
            >
                <CountrySelect value={country} onChange={setCountry} />

                <div style={{ flex: 1, overflowY: "auto" }}>
                    {channels.map((c, i) => (
                        <div
                            key={i}
                            onClick={() => setCurrent(c.streamUrl)}
                            style={{
                                padding: 12,
                                cursor: "pointer",
                                display: "flex",
                                alignItems: "center",
                                gap: 10,
                                borderBottom: "1px solid #222"
                            }}
                        >
                            <img src={c.logo} width={40} height={40} />
                            <div>
                                <div>{c.name}</div>
                                {c.group && (
                                    <small style={{ color: "#aaa" }}>{c.group}</small>
                                )}
                            </div>
                        </div>
                    ))}
                </div>
            </div>

            {/* Player */}
            <div style={{ flex: 1 }}>
                <Player url={current} />
            </div>
        </div>
    );
}
