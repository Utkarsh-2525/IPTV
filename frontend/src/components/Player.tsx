import { useEffect, useRef } from "react";
import Hls from "hls.js";

type Props = {
    url: string | null;
};

export default function Player({ url }: Props) {
    const videoRef = useRef<HTMLVideoElement>(null);

    useEffect(() => {
        if (!url || !videoRef.current) return;

        const video = videoRef.current;

        if (Hls.isSupported()) {
            const hls = new Hls();
            hls.loadSource(url);
            hls.attachMedia(video);
            return () => hls.destroy();
        } else {
            video.src = url;
        }
    }, [url]);

    return (
        <video
            ref={videoRef}
            controls
            autoPlay
            style={{
                width: "100%",
                height: "100%",
                background: "black"
            }}
        />
    );
}
